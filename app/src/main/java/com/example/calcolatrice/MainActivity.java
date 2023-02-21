package com.example.calcolatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.math.BigDecimal;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class MainActivity extends AppCompatActivity {
    private Button button0, button1, button2, button3, button4,
            button5, button6, button7, button8, button9, buttonDecimal,
            buttonPlus, buttonMinus, buttonMultiply, buttonClear, buttonDivide,
            buttonRoot, buttonLeftParenthesis, buttonRightParenthesis, buttonEquals;

    private StringBuilder expression = new StringBuilder();
    private double result = 0;

    private TextView resultTextView;
    private StringBuilder numberBuilder;

    private double number1;
    private double number2;
    private String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Recupera i riferimenti agli elementi dell'interfaccia utente
        resultTextView = findViewById(R.id.resultTextView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonClear = findViewById(R.id.buttonClear);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonRoot = findViewById(R.id.buttonRoot);
        buttonLeftParenthesis = findViewById(R.id.buttonLeftParenthesis);
        buttonRightParenthesis = findViewById(R.id.buttonRightParenthesis);
        buttonEquals = findViewById(R.id.buttonEquals);

        // Imposta il testo vuoto nel TextView del risultato
        resultTextView.setText("");

        // Aggiungi i listener per la gestione degli eventi di click sui pulsanti

        // evento tasto per il numero 0
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("0");
                resultTextView.append("0");
            }
        });

        // evento tasto per il numero 1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("1");
                resultTextView.append("1");
            }
        });

        // evento tasto per il numero 2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("2");
                resultTextView.append("2");
            }
        });

        // evento tasto per il numero 3
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("3");
                resultTextView.append("3");
            }
        });

        // evento tasto per il numero 4
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("4");
                resultTextView.append("4");
            }
        });

        // evento tasto per il numero 5
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("5");
                resultTextView.append("5");
            }
        });

        // evento tasto per il numero 6
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("6");
                resultTextView.append("6");
            }
        });

        // evento tasto per il numero 7
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("7");
                resultTextView.append("7");
            }
        });

        // evento tasto per il numero 8
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("8");
                resultTextView.append("8");
            }
        });

        // evento tasto per il numero 9
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                expression.append("9");
                resultTextView.append("9");
            }
        });

        // evento tasto per la virgola "."
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numberBuilder.toString().contains(".")) {
                    numberBuilder.append(".");
                    resultTextView.setText(numberBuilder.toString());
                }
            }
        });

        // evento tasto per l'addizione
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + "+");
            }
        });

        // evento tasto per la sottrazione
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + "-");
            }
        });

        // evento tasto per la moltiplicazione
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + "*");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expression.setLength(0);
                resultTextView.setText("");
            }
        });

        // evento tasto per la divisione
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + "/");
            }
        });

        // evento tasto per la radice
        buttonRoot.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();

                // Controllo se la stringa nel textview contiene un numero valido
                try {
                    double number = Double.parseDouble(currentText);
                } catch (NumberFormatException e) {
                    resultTextView.setText("Error: Insert a valid number first");
                    return;
                }

                double number = Double.parseDouble(currentText);
                double result = Math.sqrt(number);
                resultTextView.setText(String.valueOf(result));
            }
        });


        // evento tasto per la parentesi tonda sinistra
        buttonLeftParenthesis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + "(");
            }
        });

        // evento tasto per la parentesi tonda destra
        buttonRightParenthesis.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String currentText = resultTextView.getText().toString();
                resultTextView.setText(currentText + ")");
            }
        });

        // evento per il tasto uguale
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    // Valuta l'espressione inserita dall'utente
                    Expression expression = new ExpressionBuilder(resultTextView.getText().toString()).build();
                    BigDecimal result = new BigDecimal(expression.evaluate());
                    resultTextView.setText(result.toPlainString());
                } catch (Exception e) {
                    // Gestisci eventuali errori nella valutazione dell'espressione
                    resultTextView.setText("Error");
                }
            }
        });

        numberBuilder = new StringBuilder();
    }
}
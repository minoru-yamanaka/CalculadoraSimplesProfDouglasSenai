package com.example.calc;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Declaração de variáveis para os botões de operação e campos de texto
    Button btSomar, btSubtrair, btMultiplicar, btDividir;
    EditText edInserir1, edInserir2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicialização dos botões e campos de texto
        btSomar = findViewById(R.id.btSomar);
        btSubtrair = findViewById(R.id.btSubtrair);
        btMultiplicar = findViewById(R.id.btMultiplicar);
        btDividir = findViewById(R.id.btDividir);
        edInserir1 = findViewById(R.id.edInserir1);
        edInserir2 = findViewById(R.id.edInserir2);

        // Adição de ouvintes de clique para cada botão de operação
        btSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('+');
            }
        });

        btSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('-');
            }
        });

        btMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('*');
            }
        });

        btDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizarOperacao('/');
            }
        });
    }

    // Método para realizar operações de acordo com o operador especificado
    private void realizarOperacao(char operador) {
        double num1 = Double.parseDouble(edInserir1.getText().toString());
        double num2 = Double.parseDouble(edInserir2.getText().toString());
        double resultado = 0;

        // Switch-case para determinar a operação com base no operador
        switch (operador) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                // Verifica a divisão por zero
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    exibirMensagem("Erro: Divisão por zero");
                    return;
                }
                break;
        }

        // Exibe o resultado em um AlertDialog
        exibirMensagem("Resultado: " + resultado);
    }

    // Método para exibir mensagens em um AlertDialog
    private void exibirMensagem(String mensagem) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(this);
        dialogo.setTitle("Resultado");
        dialogo.setMessage(mensagem);
        dialogo.setNeutralButton("Ok", null);
        dialogo.show();
    }
}

package com.ananda.calculadoracarrinho

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.ananda.calculadoracarrinho.data.itensCarrinhoIniciais
import com.ananda.calculadoracarrinho.domain.gerarRelatorioLogcat
import com.ananda.calculadoracarrinho.ui.TelaCarrinho

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gerarRelatorioLogcat(itensCarrinhoIniciais)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TelaCarrinho(itens = itensCarrinhoIniciais)
                }
            }
        }
    }
}
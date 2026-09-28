package com.ananda.calculadoracarrinho.domain

import android.util.Log
import com.ananda.calculadoracarrinho.model.ItemCarrinho

fun gerarRelatorioLogcat(itens: List<ItemCarrinho>) {
    Log.d("RelatorioCarrinho", "--- PRODUTOS COM DESCONTO APLICADO ---")
    itens.map { it.produto }
        .filter { it.descontoPercentual > 0.0 }
        .sortedByDescending { it.calcularValorTotal() }
        .forEach { produto ->
            Log.d("RelatorioCarrinho", "Nome: ${produto.nome} | Valor Final: R$ ${String.format("%.2f", produto.calcularValorTotal())}")
        }
}
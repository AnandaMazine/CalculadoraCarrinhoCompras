package com.ananda.calculadoracarrinho.domain

import android.util.Log
import com.ananda.calculadoracarrinho.model.ItemCarrinho
import com.ananda.calculadoracarrinho.model.Produto
fun calcularValorFinalProduto(produto: Produto): Double {
    val desconto = produto.precoUnitario * (produto.descontoPercentual / 100.0)
    return produto.precoUnitario - desconto
}

fun calcularValorFinalItem(item: ItemCarrinho): Double {
    return calcularValorFinalProduto(item.produto) * item.quantidade
}

fun gerarRelatorioLogcat(itens: List<ItemCarrinho>) {
    Log.d("RelatorioCarrinho", "--- PRODUTOS COM DESCONTO APLICADO (NO CARRINHO) ---")

    itens.filter { it.produto.descontoPercentual > 0.0 }
        .sortedByDescending { calcularValorFinalItem(it) }
        .forEach { item ->
            val valorTotalItem = calcularValorFinalItem(item)
            Log.d("RelatorioCarrinho", "Nome: ${item.produto.nome} | Qtd: ${item.quantidade} | Valor Final Total: R$ ${String.format("%.2f", valorTotalItem)}")
        }

    val valoresTotais = itens.map { calcularValorFinalItem(it) }
    if (valoresTotais.isNotEmpty()) {
        val totalGeralReduce = valoresTotais.reduce { acc, valor -> acc + valor }
        Log.d("RelatorioCarrinho", "Valor Total Geral via Reduce: R$ ${String.format("%.2f", totalGeralReduce)}")
    }
}
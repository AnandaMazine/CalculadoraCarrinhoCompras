package com.ananda.calculadoracarrinho.model

import com.ananda.calculadoracarrinho.domain.calcularValorFinalItem

data class ItemCarrinho(
    val produto: Produto,
    val quantidade: Int
) : Pagável {
    override fun calcularValorTotal(): Double {
        return calcularValorFinalItem(this)
    }
}
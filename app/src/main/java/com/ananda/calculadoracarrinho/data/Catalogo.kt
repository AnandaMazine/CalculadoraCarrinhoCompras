package com.ananda.calculadoracarrinho.data

import com.ananda.calculadoracarrinho.model.ItemCarrinho
import com.ananda.calculadoracarrinho.model.Produto

val catalogoProdutos = listOf(
    Produto(
        nome = "Notebook Dell Inspiron 15 polegadas",
        precoUnitario = 3499.00,
        descricao = "Um notebook rápido para multitarefas e trabalho pesado.",
        descontoPercentual = 5.0
    ),
    Produto(
        nome = "Mouse sem fio",
        precoUnitario = 89.90,
        descricao = null,
        descontoPercentual = 0.0
    ),
    Produto(
        nome = "Teclado mecânico RGB",
        precoUnitario = 349.90,
        descricao = "Switch azul, ABNT2",
        descontoPercentual = 0.0
    ),
    Produto(
        nome = "Monitor 24 polegadas Full HD",
        precoUnitario = 899.00,
        descricao = "Painel IPS com excelente fidelidade de cores.",
        descontoPercentual = 10.0
    ),
    Produto(
        nome = "Headset Gamer USB",
        precoUnitario = 199.90,
        descricao = "Com microfone ajustável e som estéreo.",
        descontoPercentual = 0.0
    ),
    Produto(
        nome = "Mousepad Grande Gamer",
        precoUnitario = 49.90,
        descricao = null,
        descontoPercentual = 0.0
    )
)

val itensCarrinhoIniciais = listOf(
    ItemCarrinho(catalogoProdutos[0], quantidade = 2),
    ItemCarrinho(catalogoProdutos[1], quantidade = 1),
    ItemCarrinho(catalogoProdutos[2], quantidade = 1)
)
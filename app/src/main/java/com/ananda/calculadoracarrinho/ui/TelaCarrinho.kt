package com.ananda.calculadoracarrinho.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ananda.calculadoracarrinho.model.ItemCarrinho

@Composable
fun TelaCarrinho(itens: List<ItemCarrinho>) {
    val subtotalBruto = itens.sumOf { it.produto.precoUnitario * it.quantidade }
    val totalDescontos = itens.sumOf { (it.produto.precoUnitario * (it.produto.descontoPercentual / 100.0)) * it.quantidade }
    val valorTotalFinal = itens.sumOf { it.calcularValorTotal() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "🛒 Meu Carrinho",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(itens) { item ->
                ItemProdutoCard(item = item)
            }
        }

        HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

        ResumoFinanceiro(
            subtotal = subtotalBruto,
            descontos = totalDescontos,
            total = valorTotalFinal
        )
    }
}

@Composable
fun ItemProdutoCard(item: ItemCarrinho) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = item.produto.nome,
                style = MaterialTheme.typography.bodyLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = item.produto.descricao ?: "Sem descrição",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "R$ ${String.format("%.2f", item.produto.calcularValorTotal())}",
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "x${item.quantidade}   R$ ${String.format("%.2f", item.calcularValorTotal())}",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Composable
fun ResumoFinanceiro(subtotal: Double, descontos: Double, total: Double) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LinhaResumo(titulo = "Subtotal", valor = "R$ ${String.format("%.2f", subtotal)}")
        LinhaResumo(titulo = "Descontos", valor = "-R$ ${String.format("%.2f", descontos)}")
        HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
        LinhaResumo(titulo = "TOTAL", valor = "R$ ${String.format("%.2f", total)}")
    }
}

@Composable
fun LinhaResumo(titulo: String, valor: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 2.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = titulo, style = MaterialTheme.typography.bodyLarge)
        Text(text = valor, style = MaterialTheme.typography.bodyLarge)
    }
}
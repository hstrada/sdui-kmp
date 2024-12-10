package server.driven.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import server.driven.ui.components.RockText
import server.driven.ui.domain.Offers


@Composable
fun OfferWidget(offer: Offers) =
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .background(color = Color.LightGray)
            .padding(8.dp)
    ) {
        RockText(text = "Sua Oferta")
        RockText(text = offer.name)
        RockText(text = offer.type.name)
    }


@Preview
@Composable
fun OfferWidgetPreview() =
    OfferWidget(
        offer = Offers(
            id = 1,
            name = "Offer A",
            type = Offers.OfferType.TypeA
        )
    )
package ru.maxsdev.top_headlines.headline

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import ru.maxsdev.api.dto.ArticleDto
import ru.maxsdev.api.model.ArticleSource
import ru.maxsdev.theme.views.Body
import ru.maxsdev.theme.views.Header
import ru.maxsdev.theme.views.Label
import ru.maxsdev.top_headlines.R

@Composable
fun Headline(article: ArticleDto) {
    Surface(modifier = Modifier.padding(horizontal = 24.dp)) {
        Column {
            Row {
                Label(text = article.source?.name ?: "")
                Spacer(modifier = Modifier.weight(1.0f))
                Label(text = "5 min read")
            }
            Header(
                text = article.title ?: "",
                modifier = Modifier.padding(vertical = 12.dp)
            )
            AsyncImage(
                model = article.urlToImage,
                contentDescription = article.source?.name,
                placeholder = painterResource(R.drawable.placeholder),
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(8.dp))
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Label(text = article.author ?: "", maxLines = 2, modifier = Modifier.weight(1.0f))
                Spacer(modifier = Modifier.size(16.dp))
                Label(text = article.publishedAt ?: "", maxLines = 1, modifier = Modifier.wrapContentWidth())
            }
            Body(
                text = article.description ?: "",
                modifier = Modifier.padding(vertical = 12.dp)
            )
        }
    }
}

@[Composable Preview(showBackground = true)]
private fun HeadlinePreview() {
    val article = ArticleDto(
        source = ArticleSource(
            id = "the-washington-post",
            name = "The Washington Post"
        ),
        author = "Rebecca Tan, Katerina Ang, Emily Ding",
        title = "Anwar Ibrahim named Malaysia's 10th prime minister - The Washington Post",
        description = "Malaysia's king names Anwar Ibrahim as prime minister, bringing a temporary end to a chaotic election season.",
        url = "https://www.washingtonpost.com/world/2022/11/24/malaysia-new-prime-minister-anwar-ibrahim/",
        urlToImage = "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/DX5PVT5QGHN54SHRPW4EZOCE7Y.jpg&w=1440",
        publishedAt = "2022-11-24T12:27:57Z",
        content = "Comment on this story\r\nSINGAPORE The wait is over. And its a comeback.\r\nNearly a week after Malaysias general election resulted in a hung parliament, longtime opposition leader Anwar Ibrahim appears … [+7399 chars]"
    )
    Headline(article)
}

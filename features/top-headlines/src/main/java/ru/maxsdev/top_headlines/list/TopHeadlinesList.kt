package ru.maxsdev.top_headlines.list

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import kotlinx.coroutines.flow.flowOf
import ru.maxsdev.api.dto.ArticleDto
import ru.maxsdev.api.model.ArticleSource
import ru.maxsdev.theme.DividerColor
import ru.maxsdev.theme.FunnelTheme
import ru.maxsdev.top_headlines.headline.Headline

@Composable
fun TopHeadlinesList(articles: LazyPagingItems<ArticleDto>) {
    FunnelTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            LazyColumn {
                items(items = articles, key = { it.url ?: "" }) { article ->
                    Spacer(modifier = Modifier.height(24.dp))
                    Headline(article!!)
                    Spacer(modifier = Modifier.height(24.dp))
                    Divider(thickness = 1.dp, color = DividerColor, modifier = Modifier.padding(horizontal = 24.dp))
                }
            }
        }
    }
}

@[Composable Preview]
private fun TopHeadlinesListPreview() {
    val mockList = listOf(
        ArticleDto(
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
        ),
        ArticleDto(
            source = ArticleSource(
                id = "the-washington-post",
                name = "The Washington Post"
            ),
            author = "Rebecca Tan, Katerina Ang, Emily Ding",
            title = "Anwar Ibrahim named Malaysia's 10th prime minister - The Washington Post",
            description = "Malaysia's king names Anwar Ibrahim as prime minister, bringing a temporary end to a chaotic election season.",
            url = "https://www.washingtonpost.com/world/2022/11/24/malaysia-new-prime-minister-anwar-ibrahim/1",
            urlToImage = "https://www.washingtonpost.com/wp-apps/imrs.php?src=https://arc-anglerfish-washpost-prod-washpost.s3.amazonaws.com/public/DX5PVT5QGHN54SHRPW4EZOCE7Y.jpg&w=1440",
            publishedAt = "2022-11-24T12:27:57Z",
            content = "Comment on this story\r\nSINGAPORE The wait is over. And its a comeback.\r\nNearly a week after Malaysias general election resulted in a hung parliament, longtime opposition leader Anwar Ibrahim appears … [+7399 chars]"
        )
    )
    val articles = flowOf(PagingData.from(mockList)).collectAsLazyPagingItems()
    TopHeadlinesList(articles)
}

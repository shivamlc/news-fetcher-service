package com.sg_tech.news_fetcher_service.external_news_client.mapper;

import com.sg_tech.news_fetcher_service.external_news_client.dto.internal.NewsSourceDto;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.enums.Language;

public class NewsSourceMapper {

    public static NewsSourceDto mapToDto(com.sg_tech.news_fetcher_service.external_news_client.model.Source newsSource) {
        if (newsSource == null) {
            return null;
        }

        return NewsSourceDto.builder()
                .id(newsSource.getId())
                .name(newsSource.getName())
                .description(newsSource.getDescription())
                .url(newsSource.getUrl())
                .category(Category.valueOf(newsSource.getCategory()))
                .language(Language.valueOf(newsSource.getLanguage())) 
                .country(Country.valueOf(newsSource.getCountry())) 
                .build();
    }

}

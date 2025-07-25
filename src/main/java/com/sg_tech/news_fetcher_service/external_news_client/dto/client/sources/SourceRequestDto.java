package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;


import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Language;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceRequestDto {
    // Optional parameters for filtering sources
    private Category category;
    private Language language;
    private Country country;
}

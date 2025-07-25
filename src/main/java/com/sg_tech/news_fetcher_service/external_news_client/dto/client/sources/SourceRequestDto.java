package com.sg_tech.news_fetcher_service.external_news_client.dto.client.sources;


import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Category;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Country;
import com.sg_tech.news_fetcher_service.external_news_client.dto.enums.Language;

import io.micrometer.common.lang.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SourceRequestDto {
    // Optional parameters for filtering sources
    @Nullable
    private Category category;

    @Nullable
    private Language language;

    @Nullable
    private Country country;
}

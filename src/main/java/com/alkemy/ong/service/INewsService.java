package com.alkemy.ong.service;

import com.alkemy.ong.dto.NewsDTO;

public interface INewsService {

    NewsDTO save(NewsDTO dto);

    NewsDTO getById(Long id);
}

package com.techelevator.dao;

import java.util.List;

public interface ImageDao {
    List<String> listImageUrls(int postId);

    void addImages(List<String> urls, int postId);
}
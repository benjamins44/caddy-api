package fr.caddy.coursesu.basket.service;

import fr.caddy.common.bean.BasketPurchase;

import java.util.List;

public interface BasketUService {

    public void basket(List<BasketPurchase> basketPurchases, String login, String password);
}

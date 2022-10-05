package com.onuremren.googleyemekapp.data

import android.view.Menu
import com.onuremren.googleyemekapp.constans.ItemType
import com.onuremren.googleyemekapp.model.MenuItem

object DataSource {
    val menuItems = mapOf(
        "Kuru Fasülye" to MenuItem(
            name = "Kuru Fasülye",
            description = "Kuru Fasülye",
            price = 20.0,
            type = ItemType.MAIN_COURSE,

        ),
        "İzmir Köfte" to com.onuremren.googleyemekapp.model.MenuItem(
            name = "İzmir Köfte",
            description = "Salçalı sos ve patates eşliğinde",
            price = 20.0,
            type = ItemType.MAIN_COURSE,

        ),
        "Taze Fasülye" to com.onuremren.googleyemekapp.model.MenuItem(
            name = "Taze Fasülye",
            description = "Yeşil Fasülye",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "TavukSote" to MenuItem(
            name = "Tavuk Sote",
            description = "Göğüs eti ile yapılmaktadır.",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Kıymalı Patates" to com.onuremren.googleyemekapp.model.MenuItem(
            name = "Kıymalı Patates",
            description = "Kıymalı Patates",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Nohut" to MenuItem(
            name = "Nohut",
            description = "Nohut",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Tavuk Haşlama" to MenuItem(
            name = "Tavuk Haşlama",
            description = "Haşlanmış patates ve havuç eşliğinde",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Patlıcan Musakka" to MenuItem(
            name = "Patlıcan Musakka",
            description = "Fırınlanmış özel soslu musakka",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Etli Patates" to MenuItem(
            name = "Etli Patates",
            description = "Haşlanmış patates ve dana eti",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "şinitzel" to MenuItem(
            name = "Şinitzel",
            description = "Galeta ununa bulanmış kızarmış Tavuk Göğsü",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "sulu köfte" to MenuItem(
          name = "Sulu Köfte",
          description = "Patates, Biber, Domates ve Salçalı Sos",
          price = 20.0,
          type =  ItemType.MAIN_COURSE
        ),
        "ciğer" to MenuItem(
            name = "Arnavut Ciğeri",
            description = "Dana ciğeri, patates ve salata ile birlikte",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Biber Dolma" to MenuItem(
            name = "Biber Dolma",
            description = "Etli biber dolma",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Fırın Tavuk" to MenuItem(
            name = "Fırın Tavuk",
            description = "Domates, patates ve biber eşliğinde",
            price = 20.0,
            type = ItemType.MAIN_COURSE
        ),
        "Makarna" to MenuItem(
            name = "Makarna",
            description = "Salça soslu Makarna",
            price = 15.0,
            type = ItemType.SIDE_DISH
        ),
        "Pilav" to MenuItem(
            name = "Pilav",
            description = "Pirinç Pilavı",
            price = 15.0,
            type = ItemType.SIDE_DISH
        ),
        "Bulgur Pilavı" to MenuItem(
            name = "Bulgur Pilavı",
            description = "Domatesli salçalı bulgur pilavı",
            price = 15.0,
            type = ItemType.SIDE_DISH
        ),
        "Mantı" to MenuItem(
            name = "Mantı",
            description = "Yoğurt ve salçalı sos ile",
            price = 15.0,
            type = ItemType.SIDE_DISH
        ),
        "Mercimek Çorbası" to MenuItem(
            name = "Mercimek Çorbası",
            description = "Mercimek Çorbası",
            price = 10.0,
            type = ItemType.SIDE_DISH
        ),
        "Salata" to MenuItem(
            name = "Salata",
            description = "Kıvırcık, domates, salatalık ve zeytinyağı",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Cacık" to MenuItem(
            name = "Cacık",
            description = "Cacık",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Yoğurt" to MenuItem(
            name = "Yoğurt",
            description = "Yoğurt",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Sütlaç" to MenuItem(
            name = "Sütlaç",
            description = "Günlük yapılmaktadır.",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        ),
        "Kola" to MenuItem(
            name = "Kola",
            description = "Kola",
            price = 10.0,
            type = ItemType.ACCOMPANIMENT
        )
    )
}
package com.srl.mob.mcomic.model

import com.google.gson.annotations.SerializedName

class Comic {

    /*
    *
    * Json Schema
    * All data is not required
    *
    * {
    "id": 59524,
    "digitalId": 0,
    "title": "All-New, All-Different Avengers (2015) #12 (Kuder Mighty Men Variant)",
    "issueNumber": 12,
    "variantDescription": "Kuder Mighty Men Variant",
    "description": null,
    "modified": "2016-07-07T10:51:55-0400",
    "isbn": "",
    "upc": "75960608299501231",
    "diamondCode": "",
    "ean": "",
    "issn": "",
    "format": "Comic",
    "pageCount": 32,
    "textObjects": [],
    "resourceURI": "http://gateway.marvel.com/v1/public/comics/59524",
    "urls": [{
        "type": "detail",
        "url": "http://marvel.com/comics/issue/59524/all-new_all-different_avengers_2015_12_kuder_mighty_men_variant/kuder_mighty_men_variant?utm_campaign=apiRef&utm_source=4ef00e6dc94195b361b9720dcf7f1556"
    }],


    "series": {
        "resourceURI": "http://gateway.marvel.com/v1/public/series/20443",
        "name": "All-New, All-Different Avengers (2015 - Present)"
    }

    ,
    "variants": [{
            "resourceURI": "http://gateway.marvel.com/v1/public/comics/55365",
            "name": "All-New, All-Different Avengers (2015) #12"
        },
        {
            "resourceURI": "http://gateway.marvel.com/v1/public/comics/60053",
            "name": "All-New, All-Different Avengers (2015) #12 (Nakayama Death of X Variant)"
        }
    ],


    "collections": [],
    "collectedIssues": [],

    "dates": [{
            "type": "onsaleDate",
            "date": "2029-12-31T00:00:00-0500"
        },
        {
            "type": "focDate",
            "date": "2016-06-29T00:00:00-0400"
        }
    ],

    "prices": [{
        "type": "printPrice",
        "price": 3.99
    }],

    "thumbnail": {
        "path": "http://i.annihil.us/u/prod/marvel/i/mg/b/40/image_not_available",
        "extension": "jpg"
    },

    "images": [],

    "creators": {
        "available": 2,
        "collectionURI": "http://gateway.marvel.com/v1/public/comics/59524/creators",
        "items": [

        {
                "resourceURI": "http://gateway.marvel.com/v1/public/creators/2133",
                "name": "Tom Brevoort",
                "role": "editor"
            }

            ,
            {
                "resourceURI": "http://gateway.marvel.com/v1/public/creators/12979",
                "name": "Aaron Kuder",
                "role": "penciller (cover)"
            }
        ],
        "returned": 2
    },

    "characters": {
        "available": 0,
        "collectionURI": "http://gateway.marvel.com/v1/public/comics/59524/characters",
        "items": [],
        "returned": 0
    },
    "stories": {
        "available": 2,
        "collectionURI": "http://gateway.marvel.com/v1/public/comics/59524/stories",
        "items": [{
                "resourceURI": "http://gateway.marvel.com/v1/public/stories/129554",
                "name": "cover from All-New, All-Different Avengers (2015) #12 (TBD ARTIST MOP VARIANT)",
                "type": "cover"
            },
            {
                "resourceURI": "http://gateway.marvel.com/v1/public/stories/129555",
                "name": "story from All-New, All-Different Avengers (2015) #12 (TBD ARTIST MOP VARIANT)",
                "type": "interiorStory"
            }
        ],
        "returned": 2
    },
    "events": {
        "available": 0,
        "collectionURI": "http://gateway.marvel.com/v1/public/comics/59524/events",
        "items": [],
        "returned": 0
    }
}
     */

    @SerializedName("id")
    var id:Long=0

    @SerializedName("digitalId")
    var digitalId:Long=0

    @SerializedName("title")
    var title:String?=null

    @SerializedName("issueNumber")
    var issueNumber:Long=0

    @SerializedName("thumbnail")
    var thumbnail:Thumbnail?=null
}
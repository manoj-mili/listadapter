package com.carnot.recyclerviewlistadapter

import org.json.JSONArray

val data =
    "[\n        {\n\"userId\": 1,\n\"id\": 1,\n\"title\": \"sunt aut facere repellat provident occaecati excepturi optio reprehenderit\",\n\"body\": \"quia et suscipit\\nsuscipit recusandae consequuntur expedita et cum\\nreprehenderit molestiae ut ut quas totam\\nnostrum rerum est autem sunt rem eveniet architecto\"\n        },\n        {\n\"userId\": 1,\n\"id\": 2,\n\"title\": \"qui est esse\",\n\"body\": \"est rerum tempore vitae\\nsequi sint nihil reprehenderit dolor beatae ea dolores neque\\nfugiat blanditiis voluptate porro vel nihil molestiae ut reiciendis\\nqui aperiam non debitis possimus qui neque nisi nulla\"\n        },\n        {\n\"userId\": 1,\n\"id\": 3,\n\"title\": \"ea molestias quasi exercitationem repellat qui ipsa sit aut\",\n\"body\": \"et iusto sed quo iure\\nvoluptatem occaecati omnis eligendi aut ad\\nvoluptatem doloribus vel accusantium quis pariatur\\nmolestiae porro eius odio et labore et velit aut\"\n        },\n        {\n\"userId\": 1,\n\"id\": 4,\n\"title\": \"eum et est occaecati\",\n\"body\": \"ullam et saepe reiciendis voluptatem adipisci\\nsit amet autem assumenda provident rerum culpa\\nquis hic commodi nesciunt rem tenetur doloremque ipsam iure\\nquis sunt voluptatem rerum illo velit\"\n        },\n        {\n\"userId\": 1,\n\"id\": 5,\n\"title\": \"nesciunt quas odio\",\n\"body\": \"repudiandae veniam quaerat sunt sed\\nalias aut fugiat sit autem sed est\\nvoluptatem omnis possimus esse voluptatibus quis\\nest aut tenetur dolor neque\"\n        },\n        {\n\"userId\": 1,\n\"id\": 6,\n\"title\": \"dolorem eum magni eos aperiam quia\",\n\"body\": \"ut aspernatur corporis harum nihil quis provident sequi\\nmollitia nobis aliquid molestiae\\nperspiciatis et ea nemo ab reprehenderit accusantium quas\\nvoluptate dolores velit et doloremque molestiae\"\n        },\n        {\n\"userId\": 1,\n\"id\": 7,\n\"title\": \"magnam facilis autem\",\n\"body\": \"dolore placeat quibusdam ea quo vitae\\nmagni quis enim qui quis quo nemo aut saepe\\nquidem repellat excepturi ut quia\\nsunt ut sequi eos ea sed quas\"\n        },\n        {\n\"userId\": 1,\n\"id\": 8,\n\"title\": \"dolorem dolore est ipsam\",\n\"body\": \"dignissimos aperiam dolorem qui eum\\nfacilis quibusdam animi sint suscipit qui sint possimus cum\\nquaerat magni maiores excepturi\\nipsam ut commodi dolor voluptatum modi aut vitae\"\n        },\n        {\n\"userId\": 1,\n\"id\": 9,\n\"title\": \"nesciunt iure omnis dolorem tempora et accusantium\",\n\"body\": \"consectetur animi nesciunt iure dolore\\nenim quia ad\\nveniam autem ut quam aut nobis\\net est aut quod aut provident voluptas autem voluptas\"\n        },\n        {\n\"userId\": 1,\n\"id\": 10,\n\"title\": \"optio molestias id quia eum\",\n\"body\": \"quo et expedita modi cum officia vel magni\\ndoloribus qui repudiandae\\nvero nisi sit\\nquos veniam quod sed accusamus veritatis error\"\n        }\n    ]"

fun getListOfPost(count: Int): List<Post> {
    val postList = mutableListOf<Post>()
    val dataList = JSONArray(data)
    for (i in 0 until dataList.length()) {
        val jsonPost = dataList.getJSONObject(i)
        val post =
            Post(jsonPost.getInt("id"), jsonPost.getString("title"), jsonPost.getString("body"))
        postList.add(post)
    }
    val limit = when {
        count > postList.size -> postList.size
        else -> count
    }

    return postList.subList(0, limit);
}
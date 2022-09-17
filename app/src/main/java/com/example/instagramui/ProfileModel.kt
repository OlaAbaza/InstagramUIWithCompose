package com.example.instagramui

data class ProfileModel(
    var profileName: String,
    var profileDesc: String,
    var profileDisplayName: String,
    var profileDescUrl: String,
    var postsNum: String,
    var followersNum: String,
    var followingNum: String,
    var highlights: List<Pair<Int, String>>,
    var contentImageList: List<Int> = imageList
)

var imageList = listOf(
    R.drawable.pic1,
    R.drawable.pic2,
    R.drawable.pic3,
    R.drawable.pic4,
    R.drawable.pic5,
    R.drawable.pic6,
    R.drawable.pic7,
    R.drawable.pic8,
    R.drawable.pic9,
    R.drawable.pic10,
    R.drawable.pic12,
    R.drawable.pic13,
    R.drawable.pic14,
    R.drawable.pic15,
    R.drawable.pic16,
    R.drawable.pic17,
    R.drawable.pic18,
    R.drawable.pic19,
    R.drawable.pic20,
    R.drawable.pic21,
    R.drawable.pic23,
    R.drawable.pic24,
    R.drawable.pic25,
    R.drawable.pic26,
    R.drawable.pic27,
    R.drawable.pic28,
    R.drawable.pic29,
    R.drawable.pic31
)

fun getDisneyProfileModel() =
    ProfileModel(
        profileName = "disney",
        profileDesc = "Disney magic right at your fingertips! ✨",
        profileDisplayName = "Disney",
        profileDescUrl = "di.sn/6002Mud9K",
        postsNum = "7,443",
        followersNum = "34.4M",
        followingNum = "113",
        highlights = listOf(
            Pair(R.drawable.highlight_show, "Watch"),
            Pair(R.drawable.highlight_qustions, "Quiz"),
            Pair(R.drawable.highlight_explore, "Explore"),
            Pair(R.drawable.highlight_shop, "Shop")
        )
    )

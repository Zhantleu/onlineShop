$(function () {
    $('.card__button-btn').click(function () { likeFunction(this); });
    // $('.card__button').click(function () { dislikeFunction(this);});
});

var countItem = 0;

function likeFunction(caller) {

    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "cartFunction?action=LIKE&itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        success: function () {
            countItem += 1;
            $('.cart__number').html(countItem);
            console.log(ITEM_ID + ' ' + TYPE_CATEGORY);
            console.log(countItem);
        }
    });
}
function dislikeFunction(caller) {

    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "cartFunction?action=DISLIKE&itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        data: {
            itemId: ITEM_ID,
            typeCategory: TYPE_CATEGORY
        },
        success: function () {
            countItem -= 1;
            $('.cart__number').html(countItem);
            console.log(ITEM_ID + ' ' + TYPE_CATEGORY);
        }
    });
}
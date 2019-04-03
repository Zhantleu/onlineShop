$(function () {
    $('.card__button-btn').click(function () { likeFunction(this); });
    $('.dislike').click(function () { dislikeFunction(this);});
});


function likeFunction(caller) {
    var itemId = caller.parentElement.getAttribute('itemId');
    var typeCategory = caller.parentElement.getAttribute('categoryType');
    $.ajax({
        type: "POST",
        url: "addItem?itemId=" + itemId + "&categoryType=" + typeCategory,
        // Here were a two params which send to server
        // data: ""
        success: function () {
            console.log(itemId);
            console.log(typeCategory);
        }
    });
}
function dislikeFunction(caller) {
    var postId = caller.parentElement.getAttribute('postid');
    $.ajax({
        type: "POST",
        url: "addItem",
        data: 'Action=DISLIKE&PostID=' + postId,
        success: function () {}
    });
}
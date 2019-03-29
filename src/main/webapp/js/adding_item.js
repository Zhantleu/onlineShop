$(function () {
    $('.like').click(function () { likeFunction(this); });
    $('.dislike').click(function () { dislikeFunction(this);});
});


function likeFunction(caller) {
    var postId = caller.parentElement.getAttribute('postid');
    $.ajax({
        type: "POST",
        url: "addItem",
        data: 'itemId=' + postId
        ,
        success: function () {
            console.log(postId);
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
$(function () {
    $('#delete-item-id').click(function () {
        deleteItem(this);
    });
});

function deleteItem(caller) {
    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "/admin/delete-item?itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        success: function (resp) {
            if (resp.status === 'ok') {
                window.location.reload();
            } else {
                alert(resp.status);
            }
        }
    });
}
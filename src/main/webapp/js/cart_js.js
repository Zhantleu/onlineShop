// $(document).ready(function () {
//
// });

$(window).on("load", function () {
    var cikl = 0;
    for (var b = 0; b < 99; b++) {
        var a = parseInt(document.getElementById("subTotal" + b).innerHTML);
        cikl = cikl + a;
        document.getElementById('sumTest').innerHTML = cikl;
    }
});

function countMoney() {
    for (var i = 0; i < 10; i++) {
        var priceTovar = parseFloat(document.getElementById("tovarPrice" + i).innerHTML);
        var sumTovar = parseInt(document.getElementById("sumOfTovar" + i).value);
        var subTotal = document.getElementById("subTotal" + i);
        var sumTest = document.getElementById('sumTest').innerText;
        if (sumTovar < 0) {
            subTotal.innerHTML = "Teris san!";
        } else {
            subTotal.innerHTML = (priceTovar * sumTovar);
        }
    }
}

$(function () {
    $('.text--but').click(function () {
        deleteItemFormCart(this);
    });
    countMoney();
});

function deleteItemFormCart(caller) {

    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "cartFunction?action=DISLIKE&itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        success: function () {
            countItem += 1;
            $('.cart__number').html(countItem);
            console.log(ITEM_ID + ' ' + TYPE_CATEGORY);
            console.log(countItem);
        }
    });
}

function deleteElem(elem) {
    var money = 0;
    var element = document.getElementById(elem);
    element.parentNode.removeChild(element);
    for (var as = 0; as < 10; as++) {
        var subAfterLog = parseInt(document.getElementById("subTotal" + as).innerHTML);
        money = subAfterLog + money;
    }
}
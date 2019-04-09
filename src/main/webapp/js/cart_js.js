$(document).ready(function() {
   for (var i = 0;i<10;i++){
       var priceTovar = parseFloat(document.getElementById("tovarPrice"+i).innerHTML);
       var sumTovar = parseInt(document.getElementById("sumOfTovar"+i).value);
       var subTotal = document.getElementById("subTotal"+i);
       var sumTest = document.getElementById('sumTest').innerText;
       if (sumTovar < 0) {
           subTotal.innerHTML = "Teris san!";
       } else {
           subTotal.innerHTML = (priceTovar * sumTovar);
       }
   }
});

$( window ).on( "load", function() {
     var cikl = 0;
    for (var b = 0;b<99;b++){
        var a = parseInt(document.getElementById("subTotal"+b).innerHTML);
        cikl = cikl + a;
        document.getElementById('sumTest').innerHTML = cikl;
    }
});

function countMoney(id_item_price, id_sum_of_item, id_sub_total) {

    var priceTovar = parseFloat(document.getElementById(id_item_price).innerHTML);
    var sumTovar = parseInt(document.getElementById(id_sum_of_item).value);
    var subTotal = document.getElementById(id_sub_total);
    var sumTest = document.getElementById('sumTest').innerText;

    if (sumTovar < 0) {
        subTotal.innerHTML = "Teris san!";
    } else {
        subTotal.innerHTML = (priceTovar * sumTovar);
    }

    var cikl = 0;
    for (var i = 0;i<99;i++){
        var a = parseInt(document.getElementById("subTotal"+i).innerHTML);
        cikl = cikl + a;
        document.getElementById('sumTest').innerHTML = cikl;
    }

}

function deleteElem(elem){
    var money = 0;
    var element = document.getElementById(elem);
    element.parentNode.removeChild(element);
    for (var as = 0;as<10;as++){
        var subAfterLog = parseInt(document.getElementById("subTotal"+as).innerHTML);
        money = subAfterLog+money;
    }


}
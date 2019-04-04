function countMoney(id_item_price, id_sum_of_item, id_sub_total) {
    var priceTovar = parseFloat(document.getElementById(id_item_price).innerHTML);
    var sumTovar = parseInt(document.getElementById(id_sum_of_item).value);
    var subTotal = document.getElementById(id_sub_total);
    var sumTest = document.getElementById('sumTest').innerText;

    if (sumTovar < 0) {
        subTotal.innerHTML = "Teris san!";
    } else {
        subTotal.innerHTML = (priceTovar * sumTovar);
        var asdsad;
        asdsad = sumTest + subTotal;
        document.getElementById('sumTest').innerHTML = asdsad;
    }
}

function deleteElem(elem){
    var element = document.getElementById(elem);
    element.parentNode.removeChild(element);
}
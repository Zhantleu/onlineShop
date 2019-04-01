function countMoney(id_item_price, id_sum_of_item) {
    var priceTovar = parseFloat(document.getElementById(id_item_price).innerHTML);
    var sumTovar = parseInt(document.getElementById(id_sum_of_item).value);
    var subTotal = document.getElementById("subT");
    if (sumTovar < 0) {
        subTotal.innerHTML = "Teris san!";
    } else {
        var priceTotal = (priceTovar * sumTovar);
        var subT = priceTotal;
        subTotal.innerHTML = subT;
    }
    return subT;
}
function deleteElem(elem){
    var element = document.getElementById(elem);
    element.parentNode.removeChild(element);
}
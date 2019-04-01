$(document).ready(function(){
    $('.sl').slick({
        autoplay: false,
        autoplaySpeed: 1750,
        infinite: true,
        slidesToShow: 3,
        slidesToScroll: 1
    });
});

//жай набросок для корзины
function func() {
    var count = 0;
    for (var i = 0; i=1;i++) {
        var plusButton = document.getElementsByClassName("button_plus");
        var minusButton = document.getElementsByClassName("button_minus");
        if (document.onclick = plusButton) {
            count+=i;
            console.log(count);
            document.getElementById('test').value='newValueBudetTut';




        } else if (document.onclick = minusButton) {

            count -=i;
            console.log(count);
        }}
};

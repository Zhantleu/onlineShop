var tab;
var tabContent;

window.onload=function() {
    tabContent=document.getElementsByClassName('tabContent');
    tab=document.getElementsByClassName('tab');
    hideTabsContent(1);
};

function hideTabsContent(a) {
    for (var i=a; i<tabContent.length; i++) {
        tabContent[i].classList.remove('show');
        tabContent[i].classList.add("hide");
        tab[i].classList.remove('whiteborder');
    }
}
document.getElementById('tabs').onclick= function (event) {
    var target=event.target;
    if (target.className=='tab') {
        for (var i=0; i<tab.length; i++) {
            if (target == tab[i]) {
                showTabsContent(i);
                break;
            }}}}
function showTabsContent(b){
    if (tabContent[b].classList.contains('hide')) {
        hideTabsContent(0);
        tab[b].classList.add('whiteborder');
        tabContent[b].classList.remove('hide');
        tabContent[b].classList.add('show');
    }
}
// "use strict";
// "use strict";
//
// window.onload = function () {
//     document.getElementById('cap-button-out').onclick = function () {
//         openBox('caps', this);
//         return false;
//
//     };
//
// };
//
// window.onload = openTab();
//
// function openBox(id, toggler) {
//     var div = document.getElementById(id);
//     if (div.style.display === 'block') {
//         div.style.display = 'none';
//         toggler.innerHTML = 'Создать новую Шапку';
//     } else {
//         div.style.display = 'block';
//         toggler.innerHTML = 'Закрыть';
//     }
// }
//
// function openTab(evt, cityName) {
//     var i, tabcontent, tablinks;
//
//     tabcontent = document.getElementsByClassName("tabcontent");
//     for (i = 0; i < tabcontent.length; i++) {
//         tabcontent[i].style.display = "none";
//     }
//     tablinks = document.getElementsByClassName("tablinks");
//     for (i = 0; i < tablinks.length; i++) {
//         tablinks[i].className = tablinks[i].className.replace(" active", "");
//     }
//     document.getElementById(cityName).style.display = "block";
//     evt.currentTarget.className += " active";
// }


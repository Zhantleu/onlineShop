"use strict";

window.onload = function () {
    document.getElementById('cap-button-out').onclick = function () {
        openBox('caps', this);
        return false;
    };
};

window.onload = openTab();

function openBox(id, toggler) {
    var div = document.getElementById(id);
    if (div.style.display === 'block') {
        div.style.display = 'none';
        toggler.innerHTML = 'Создать новую Шапку';
    } else {
        div.style.display = 'block';
        toggler.innerHTML = 'Закрыть';
    }
}

function openTab(evt, cityName) {
    var i, tabcontent, tablinks;

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
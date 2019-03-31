function countMoney() {
	var priceTovar = parseFloat(document.getElementById("tovarPrice").innerHTML);    
	var sumTovar = parseInt(document.getElementById("sumOfTovar").value);
	var subTotal = document.getElementById("subT");
	if(sumTovar<0)
	{
		subTotal.innerHTML="Teris san!"; 
	}
	else
	{
		var priceTotal = (priceTovar*sumTovar);
		var subT = priceTotal;
		subTotal.innerHTML = subT;	
		
	}
}


/**
 * 
 */

function go(page,seccion) 
{
	if (seccion == undefined) {
		console.log(seccion);
		var pagina = page + ".jsp";
	}else{
		var pagina = page + ".jsp" + "#"+seccion;
	}
	window.location.assign(pagina);
}


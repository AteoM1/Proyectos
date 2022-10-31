/**
 * 
 */
function deleteUser(idUser){
	const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Estás seguro de eliminar este usuario?',
  text: "¡No podrás revertirlo!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: '¡Sí!, ¡Eliminar!',
  cancelButtonText: '¡No!, ¡Cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
	$.ajax({
		url:"/users/delete/" + idUser, 
		success: function(res){
			console.log(res);
		}
	});
    swalWithBootstrapButtons.fire(
      'Eliminado',
      'El usuario ha sido eliminado',
      'success'
    ).then((ok)=>{
	if(ok){
		location.href="/users/list";
	}
})
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelado',
      'El usuario está a salvo',
      'error'
    )
  }
})
}



function deleteProduct(idProduct, idUser){
	const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Estás seguro de eliminar este producto?',
  text: "¡No podrás revertirlo!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: '¡Sí!, ¡Eliminar!',
  cancelButtonText: '¡No!, ¡Cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
	$.ajax({
		url:"/index/products/delete/" + idProduct, 
		success: function(res){
			console.log(res);
		}
	});
    swalWithBootstrapButtons.fire(
      'Eliminado',
      'El producto ha sido eliminado',
      'success'
    ).then((ok)=>{
	if(ok){
		location.href="/index/products/list/products/" + idUser;
	}
})
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelado',
      'El producto está a salvo',
      'error'
    )
  }
})
}

function deletePost(idPost, idUser){
	const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Estás seguro de eliminar este post?',
  text: "¡No podrás revertirlo!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: '¡Sí!, ¡Eliminar!',
  cancelButtonText: '¡No!, ¡Cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
	$.ajax({
		url:"/index/posts/delete/" + idPost, 
		success: function(res){
			console.log(res);
		}
	});
    swalWithBootstrapButtons.fire(
      'Eliminado',
      'El post ha sido eliminado',
      'success'
    ).then((ok)=>{
	if(ok){
		location.href="/index/posts/list/posts/" + idUser;
	}
})
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelado',
      'El post está a salvo',
      'error'
    )
  }
})
}


function buyProduct(idProduct, idUser){
	const swalWithBootstrapButtons = Swal.mixin({
  customClass: {
    confirmButton: 'btn btn-success',
    cancelButton: 'btn btn-danger'
  },
  buttonsStyling: false
})

swalWithBootstrapButtons.fire({
  title: '¿Estás seguro de comprar ese producto?',
  text: "¡No podrás revertirlo!",
  icon: 'warning',
  showCancelButton: true,
  confirmButtonText: '¡Sí!, ¡Comprar!',
  cancelButtonText: '¡No!, ¡Cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.isConfirmed) {
	$.ajax({
		url:"users/buy/" + idUser + "/" + idProduct, 
		success: function(res){
			console.log(res);
		}
	});
    swalWithBootstrapButtons.fire(
      'Comprado',
      'El producto ha sido comprado',
      'success'
    ).then((ok)=>{
	if(ok){
		location.href="/index/products/list";
	}
})
  } else if (
    /* Read more about handling dismissals below */
    result.dismiss === Swal.DismissReason.cancel
  ) {
    swalWithBootstrapButtons.fire(
      'Cancelado',
      'El producto no ha sido comprado',
      'error'
    )
  }
})
}
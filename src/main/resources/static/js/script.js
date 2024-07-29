// Función para validar y enviar el formulario
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('formularioContacto2').addEventListener('submit', function(event) {
        var correo = document.getElementById('correo3').value;
        var mensaje = document.getElementById('mensaje3').value;

        // Validar que todos los campos estén completados
        if (correo.trim() === '' || mensaje.trim() === '') {
            alert('Por favor completa todos los campos del formulario.');
            event.preventDefault(); // Evitar que el formulario se envíe automáticamente
            return; // Detener la ejecución si los campos no están completados
        }

        // Validar el formato del correo electrónico
        var correoRegExp = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        if (!correoRegExp.test(correo)) {
            alert('Por favor ingresa un correo electrónico válido.');
            event.preventDefault(); // Evitar que el formulario se envíe automáticamente
            return; // Detener la ejecución si el correo electrónico no tiene el formato correcto
        }
        // Si los campos están completados y el formato del correo es correcto, el formulario se enviará automáticamente a través de FormSubmit
        // Restablecer el formulario después de enviarlo
        setTimeout(function() {
            event.target.reset();
        }, 3000); // Retraso de 3000 milisegundos (3 segundo)

        // Mostrar mensaje de éxito utilizando toastify.js
        Toastify({
            text: "¡El mensaje fue enviado con éxito!",
            duration: 3000, // Duración del mensaje en milisegundos (3 segundos en este caso)
            close: true, // Mostrar botón de cierre (X)
            gravity: "center", // Posición del mensaje en la pantalla
            backgroundColor: "#495057", // Color de fondo del mensaje (gris)
        }).showToast();
    });
});

function validateForm() {
    const estado = document.getElementById('estado').value;
    if (estado !== 'Libro Disponible' && estado !== 'Libro Prestado') {
        alert('El campo Estado solo puede contener "Libro Disponible" o "Libro Prestado".');
        return false; // Evita que el formulario se envíe
    }
    return true; // Permite que el formulario se envíe
}

// Agregar un event listener para cuando el formulario se envíe
document.addEventListener('DOMContentLoaded', (event) => {
    const form = document.querySelector('form');
    if (form) {
        form.onsubmit = validateForm;
    }
});

document.addEventListener('DOMContentLoaded', function() {
    setInterval(function(){
        const nextButton = document.querySelector('#carouselExampleFade .carousel-control-next');
        if (nextButton) {
            nextButton.click();
        }
    }, 6500);
});

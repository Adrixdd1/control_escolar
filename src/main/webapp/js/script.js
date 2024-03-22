   
   
function cargarContenido(opcion, event) {
        if(event!==undefined){
            event.preventDefault();
        }
        
        var xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                document.getElementById("navegacionPrincipal").innerHTML = xhr.responseText;
            }
        };
        var url;
        switch(opcion) {
            case 'grupos':
                url = 'paginas/grupos.jsp';
                break;
            case 'materias':
                url = 'paginas/materias.jsp';
                break;
            case 'gestionar_alumnos':
                url = 'paginas/alumnos.jsp';
                break;
            case 'registrar_asistencia':
                url = 'paginas/asistencia.jsp';
                break;
            case 'registrar_calificaciones':
                url = 'paginas/calificaciones.jsp';
                break;
            default:
                url = '';
        }
        xhr.open('GET', url, true);
        xhr.send();
    }


function enviarFormulario(event) {
            //event.preventDefault();
            var formData = new FormData(document.getElementById("formularioMaterias"));
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState == 4 && xhr.status == 200) {
                    document.getElementById("resultado").innerHTML = xhr.responseText;
                }
            };
            
            xhr.open("GET", "paginas/procesarMaterias.jsp", true);
            xhr.send(formData);
            event.preventDefault();
            }
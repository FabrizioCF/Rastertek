<%-- 
    Document   : tarjeta_tutorial
    Created on : May 18, 2019, 1:25:01 AM
    Author     : Fabrizio Cruz
--%>

<div class="card border-info my-3 mx-auto tarjeta-tema col-5" >
    <h4 class="card-header bg-transparent border-info">Nombre Tutorial</h4>
    <div class="card-body tarjeta-tema">
        <div style="display: inline-block">
            <h6 class="mx-auto">Tema 1</h6>
            <img src="GetImageStream?idTutorial=1" alt="..." class="mx-4" />
        </div>
        <div style="display: inline-block">
            <h6 class="mx-auto">Tema 2</h6>
            <img src="recursos/TUT01_08.png"
                 alt="..." class="mx-4" />
        </div>
        <div style="display: inline-block">
            <h6 class="mx-auto">Tema 3</h6>
            <img src="recursos/TUT01_08-2.png"
                 alt="..." class="mx-4" />
        </div>
    </div>
    <a  href="tutorial.jsp"
        class="card-footer bg-transparent border-info py-1 text-right">
        Ver todos
    </a>
</div>

<!-- Esto era parte de "Tutorial.jsp" -->
<jsp:include page="templates/content_template.jsp"/>
<jsp:include page="Tutoriales/Tut0101.jsp"/>
<jsp:include page="Tutoriales/Tut0102.jsp"/>
<jsp:include page="Tutoriales/Tut0103.jsp"/>
<jsp:include page="Tutoriales/Tut0104.jsp"/>
<jsp:include page="Tutoriales/Tut0105.jsp"/>
<jsp:include page="Tutoriales/Tut0106.jsp"/>
<jsp:include page="Tutoriales/Tut0107.jsp"/>
<jsp:include page="Tutoriales/Tut0108.jsp"/>
<jsp:include page="Tutoriales/Tut0109.jsp"/>
<jsp:include page="Tutoriales/Tut0110.jsp"/>                    

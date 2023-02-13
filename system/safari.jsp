<script src="../script/jquery-1.3.2.min.js"></script>
<script src="../script/jquery.blockUI.js"></script>

<script>
   function bloqueia(){
      jQuery.blockUI({ message: jQuery('#messagewait'), css: { width: '300px' } });		  
   }
</script>

<br>
<br>
<a href="../system/safari2.jsp" onclick="bloqueia();">safari</a>

<script>
jQuery( window ).unload(function() {
     jQuery('#messagewait').hide();
});
</script>




   <div id="messagewait" style="display:none; cursor: default; font-size: 14px;">
      <img src="../img/ajaxloadingbar.gif" />
      <br>
      Por favor, aguarde...
   </div>
   







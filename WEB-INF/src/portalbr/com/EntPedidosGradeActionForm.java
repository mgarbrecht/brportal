package portalbr.com;
import java.util.*;
import javax.servlet.http.*;
import org.apache.struts.action.*;
import portalbr.dbobj.table.*;
import portalbr.dbobj.view.*;
import portalbr.dbobj.procedure.*;

/**
 * Creation Date 28/09/2010 08:20:43
 * Last Modify Date 02/04/2013 15:11:10
 */

public class EntPedidosGradeActionForm extends org.apache.struts.action.ActionForm
{
  public String gde_cdgo;
  public String qtd_nume;
  public String qtd_pars;
  public String tam1;
  public String tamex1;
  public String par1;
  public String tam2;
  public String tamex2;
  public String par2;
  public String tam3;
  public String par3;
  public String tam4;
  public String par4;
  public String tam5;
  public String par5;
  public String tam6;
  public String par6;
  public String tam7;
  public String par7;
  public String tam8;
  public String par8;
  public String tam9;
  public String par9;
  public String tam10;
  public String par10;
  public String tam11;
  public String par11;
  public String tam12;
  public String par12;
  public String tam13;
  public String par13;
  public String tam14;
  public String par14;
  public String tam15;
  public String par15;
  public String tam16;
  public String par16;
  public String tam17;
  public String par17;
  public String tam18;
  public String par18;
  public String tam19;
  public String par19;
  public String tam20;
  public String par20;
  public String numero_item;
  public String total;
  public String indice;
  public String tamex3;
  public String tamex4;
  public String tamex5;
  public String tamex6;
  public String tamex7;
  public String tamex8;
  public String tamex9;
  public String tamex10;
  public String tamex11;
  public String tamex12;
  public String tamex13;
  public String tamex14;
  public String tamex15;
  public String tamex16;
  public String tamex17;
  public String tamex18;
  public String tamex19;
  public String tamex20;
  public String lin_cdgo;
  public String ref_cdgo;
  public String atualiza;
  private boolean valida = false;
  public EntPedidosGradeActionForm() {
  }
  /**
    * GDE_CDGO: Method to get the field value.
    */
  public String getGde_cdgo() {
    return gde_cdgo;
  }
  /**
    * GDE_CDGO: Method to set the field value.
    */
  public void setGde_cdgo(String PARAM) {
    gde_cdgo = PARAM;
  }
  /**
    * QTD_NUME: Method to get the field value.
    */
  public String getQtd_nume() {
    return qtd_nume;
  }
  /**
    * QTD_NUME: Method to set the field value.
    */
  public void setQtd_nume(String PARAM) {
    qtd_nume = PARAM;
  }
  /**
    * QTD_PARS: Method to get the field value.
    */
  public String getQtd_pars() {
    return qtd_pars;
  }
  /**
    * QTD_PARS: Method to set the field value.
    */
  public void setQtd_pars(String PARAM) {
    qtd_pars = PARAM;
  }
  /**
    * TAM1: Method to get the field value.
    */
  public String getTam1() {
    return tam1;
  }
  /**
    * TAM1: Method to set the field value.
    */
  public void setTam1(String PARAM) {
    tam1 = PARAM;
  }
  /**
    * TAMEX1: Method to get the field value.
    */
  public String getTamex1() {
    return tamex1;
  }
  /**
    * TAMEX1: Method to set the field value.
    */
  public void setTamex1(String PARAM) {
    tamex1 = PARAM;
  }
  /**
    * PAR1: Method to get the field value.
    */
  public String getPar1() {
    return par1;
  }
  /**
    * PAR1: Method to set the field value.
    */
  public void setPar1(String PARAM) {
    par1 = PARAM;
  }
  /**
    * TAM2: Method to get the field value.
    */
  public String getTam2() {
    return tam2;
  }
  /**
    * TAM2: Method to set the field value.
    */
  public void setTam2(String PARAM) {
    tam2 = PARAM;
  }
  /**
    * TAMEX2: Method to get the field value.
    */
  public String getTamex2() {
    return tamex2;
  }
  /**
    * TAMEX2: Method to set the field value.
    */
  public void setTamex2(String PARAM) {
    tamex2 = PARAM;
  }
  /**
    * PAR2: Method to get the field value.
    */
  public String getPar2() {
    return par2;
  }
  /**
    * PAR2: Method to set the field value.
    */
  public void setPar2(String PARAM) {
    par2 = PARAM;
  }
  /**
    * TAM3: Method to get the field value.
    */
  public String getTam3() {
    return tam3;
  }
  /**
    * TAM3: Method to set the field value.
    */
  public void setTam3(String PARAM) {
    tam3 = PARAM;
  }
  /**
    * PAR3: Method to get the field value.
    */
  public String getPar3() {
    return par3;
  }
  /**
    * PAR3: Method to set the field value.
    */
  public void setPar3(String PARAM) {
    par3 = PARAM;
  }
  /**
    * TAM4: Method to get the field value.
    */
  public String getTam4() {
    return tam4;
  }
  /**
    * TAM4: Method to set the field value.
    */
  public void setTam4(String PARAM) {
    tam4 = PARAM;
  }
  /**
    * PAR4: Method to get the field value.
    */
  public String getPar4() {
    return par4;
  }
  /**
    * PAR4: Method to set the field value.
    */
  public void setPar4(String PARAM) {
    par4 = PARAM;
  }
  /**
    * TAM5: Method to get the field value.
    */
  public String getTam5() {
    return tam5;
  }
  /**
    * TAM5: Method to set the field value.
    */
  public void setTam5(String PARAM) {
    tam5 = PARAM;
  }
  /**
    * PAR5: Method to get the field value.
    */
  public String getPar5() {
    return par5;
  }
  /**
    * PAR5: Method to set the field value.
    */
  public void setPar5(String PARAM) {
    par5 = PARAM;
  }
  /**
    * TAM6: Method to get the field value.
    */
  public String getTam6() {
    return tam6;
  }
  /**
    * TAM6: Method to set the field value.
    */
  public void setTam6(String PARAM) {
    tam6 = PARAM;
  }
  /**
    * PAR6: Method to get the field value.
    */
  public String getPar6() {
    return par6;
  }
  /**
    * PAR6: Method to set the field value.
    */
  public void setPar6(String PARAM) {
    par6 = PARAM;
  }
  /**
    * TAM7: Method to get the field value.
    */
  public String getTam7() {
    return tam7;
  }
  /**
    * TAM7: Method to set the field value.
    */
  public void setTam7(String PARAM) {
    tam7 = PARAM;
  }
  /**
    * PAR7: Method to get the field value.
    */
  public String getPar7() {
    return par7;
  }
  /**
    * PAR7: Method to set the field value.
    */
  public void setPar7(String PARAM) {
    par7 = PARAM;
  }
  /**
    * TAM8: Method to get the field value.
    */
  public String getTam8() {
    return tam8;
  }
  /**
    * TAM8: Method to set the field value.
    */
  public void setTam8(String PARAM) {
    tam8 = PARAM;
  }
  /**
    * PAR8: Method to get the field value.
    */
  public String getPar8() {
    return par8;
  }
  /**
    * PAR8: Method to set the field value.
    */
  public void setPar8(String PARAM) {
    par8 = PARAM;
  }
  /**
    * TAM9: Method to get the field value.
    */
  public String getTam9() {
    return tam9;
  }
  /**
    * TAM9: Method to set the field value.
    */
  public void setTam9(String PARAM) {
    tam9 = PARAM;
  }
  /**
    * PAR9: Method to get the field value.
    */
  public String getPar9() {
    return par9;
  }
  /**
    * PAR9: Method to set the field value.
    */
  public void setPar9(String PARAM) {
    par9 = PARAM;
  }
  /**
    * TAM10: Method to get the field value.
    */
  public String getTam10() {
    return tam10;
  }
  /**
    * TAM10: Method to set the field value.
    */
  public void setTam10(String PARAM) {
    tam10 = PARAM;
  }
  /**
    * PAR10: Method to get the field value.
    */
  public String getPar10() {
    return par10;
  }
  /**
    * PAR10: Method to set the field value.
    */
  public void setPar10(String PARAM) {
    par10 = PARAM;
  }
  /**
    * TAM11: Method to get the field value.
    */
  public String getTam11() {
    return tam11;
  }
  /**
    * TAM11: Method to set the field value.
    */
  public void setTam11(String PARAM) {
    tam11 = PARAM;
  }
  /**
    * PAR11: Method to get the field value.
    */
  public String getPar11() {
    return par11;
  }
  /**
    * PAR11: Method to set the field value.
    */
  public void setPar11(String PARAM) {
    par11 = PARAM;
  }
  /**
    * TAM12: Method to get the field value.
    */
  public String getTam12() {
    return tam12;
  }
  /**
    * TAM12: Method to set the field value.
    */
  public void setTam12(String PARAM) {
    tam12 = PARAM;
  }
  /**
    * PAR12: Method to get the field value.
    */
  public String getPar12() {
    return par12;
  }
  /**
    * PAR12: Method to set the field value.
    */
  public void setPar12(String PARAM) {
    par12 = PARAM;
  }
  /**
    * TAM13: Method to get the field value.
    */
  public String getTam13() {
    return tam13;
  }
  /**
    * TAM13: Method to set the field value.
    */
  public void setTam13(String PARAM) {
    tam13 = PARAM;
  }
  /**
    * PAR13: Method to get the field value.
    */
  public String getPar13() {
    return par13;
  }
  /**
    * PAR13: Method to set the field value.
    */
  public void setPar13(String PARAM) {
    par13 = PARAM;
  }
  /**
    * TAM14: Method to get the field value.
    */
  public String getTam14() {
    return tam14;
  }
  /**
    * TAM14: Method to set the field value.
    */
  public void setTam14(String PARAM) {
    tam14 = PARAM;
  }
  /**
    * PAR14: Method to get the field value.
    */
  public String getPar14() {
    return par14;
  }
  /**
    * PAR14: Method to set the field value.
    */
  public void setPar14(String PARAM) {
    par14 = PARAM;
  }
  /**
    * TAM15: Method to get the field value.
    */
  public String getTam15() {
    return tam15;
  }
  /**
    * TAM15: Method to set the field value.
    */
  public void setTam15(String PARAM) {
    tam15 = PARAM;
  }
  /**
    * PAR15: Method to get the field value.
    */
  public String getPar15() {
    return par15;
  }
  /**
    * PAR15: Method to set the field value.
    */
  public void setPar15(String PARAM) {
    par15 = PARAM;
  }
  /**
    * TAM16: Method to get the field value.
    */
  public String getTam16() {
    return tam16;
  }
  /**
    * TAM16: Method to set the field value.
    */
  public void setTam16(String PARAM) {
    tam16 = PARAM;
  }
  /**
    * PAR16: Method to get the field value.
    */
  public String getPar16() {
    return par16;
  }
  /**
    * PAR16: Method to set the field value.
    */
  public void setPar16(String PARAM) {
    par16 = PARAM;
  }
  /**
    * TAM17: Method to get the field value.
    */
  public String getTam17() {
    return tam17;
  }
  /**
    * TAM17: Method to set the field value.
    */
  public void setTam17(String PARAM) {
    tam17 = PARAM;
  }
  /**
    * PAR17: Method to get the field value.
    */
  public String getPar17() {
    return par17;
  }
  /**
    * PAR17: Method to set the field value.
    */
  public void setPar17(String PARAM) {
    par17 = PARAM;
  }
  /**
    * TAM18: Method to get the field value.
    */
  public String getTam18() {
    return tam18;
  }
  /**
    * TAM18: Method to set the field value.
    */
  public void setTam18(String PARAM) {
    tam18 = PARAM;
  }
  /**
    * PAR18: Method to get the field value.
    */
  public String getPar18() {
    return par18;
  }
  /**
    * PAR18: Method to set the field value.
    */
  public void setPar18(String PARAM) {
    par18 = PARAM;
  }
  /**
    * TAM19: Method to get the field value.
    */
  public String getTam19() {
    return tam19;
  }
  /**
    * TAM19: Method to set the field value.
    */
  public void setTam19(String PARAM) {
    tam19 = PARAM;
  }
  /**
    * PAR19: Method to get the field value.
    */
  public String getPar19() {
    return par19;
  }
  /**
    * PAR19: Method to set the field value.
    */
  public void setPar19(String PARAM) {
    par19 = PARAM;
  }
  /**
    * TAM20: Method to get the field value.
    */
  public String getTam20() {
    return tam20;
  }
  /**
    * TAM20: Method to set the field value.
    */
  public void setTam20(String PARAM) {
    tam20 = PARAM;
  }
  /**
    * PAR20: Method to get the field value.
    */
  public String getPar20() {
    return par20;
  }
  /**
    * PAR20: Method to set the field value.
    */
  public void setPar20(String PARAM) {
    par20 = PARAM;
  }
  /**
    * NUMERO_ITEM: Method to get the field value.
    */
  public String getNumero_item() {
    return numero_item;
  }
  /**
    * NUMERO_ITEM: Method to set the field value.
    */
  public void setNumero_item(String PARAM) {
    numero_item = PARAM;
  }
  /**
    * TOTAL: Method to get the field value.
    */
  public String getTotal() {
    return total;
  }
  /**
    * TOTAL: Method to set the field value.
    */
  public void setTotal(String PARAM) {
    total = PARAM;
  }
  /**
    * INDICE: Method to get the field value.
    */
  public String getIndice() {
    return indice;
  }
  /**
    * INDICE: Method to set the field value.
    */
  public void setIndice(String PARAM) {
    indice = PARAM;
  }
  /**
    * TAMEX3: Method to get the field value.
    */
  public String getTamex3() {
    return tamex3;
  }
  /**
    * TAMEX3: Method to set the field value.
    */
  public void setTamex3(String PARAM) {
    tamex3 = PARAM;
  }
  /**
    * TAMEX4: Method to get the field value.
    */
  public String getTamex4() {
    return tamex4;
  }
  /**
    * TAMEX4: Method to set the field value.
    */
  public void setTamex4(String PARAM) {
    tamex4 = PARAM;
  }
  /**
    * TAMEX5: Method to get the field value.
    */
  public String getTamex5() {
    return tamex5;
  }
  /**
    * TAMEX5: Method to set the field value.
    */
  public void setTamex5(String PARAM) {
    tamex5 = PARAM;
  }
  /**
    * TAMEX6: Method to get the field value.
    */
  public String getTamex6() {
    return tamex6;
  }
  /**
    * TAMEX6: Method to set the field value.
    */
  public void setTamex6(String PARAM) {
    tamex6 = PARAM;
  }
  /**
    * TAMEX7: Method to get the field value.
    */
  public String getTamex7() {
    return tamex7;
  }
  /**
    * TAMEX7: Method to set the field value.
    */
  public void setTamex7(String PARAM) {
    tamex7 = PARAM;
  }
  /**
    * TAMEX8: Method to get the field value.
    */
  public String getTamex8() {
    return tamex8;
  }
  /**
    * TAMEX8: Method to set the field value.
    */
  public void setTamex8(String PARAM) {
    tamex8 = PARAM;
  }
  /**
    * TAMEX9: Method to get the field value.
    */
  public String getTamex9() {
    return tamex9;
  }
  /**
    * TAMEX9: Method to set the field value.
    */
  public void setTamex9(String PARAM) {
    tamex9 = PARAM;
  }
  /**
    * TAMEX10: Method to get the field value.
    */
  public String getTamex10() {
    return tamex10;
  }
  /**
    * TAMEX10: Method to set the field value.
    */
  public void setTamex10(String PARAM) {
    tamex10 = PARAM;
  }
  /**
    * TAMEX11: Method to get the field value.
    */
  public String getTamex11() {
    return tamex11;
  }
  /**
    * TAMEX11: Method to set the field value.
    */
  public void setTamex11(String PARAM) {
    tamex11 = PARAM;
  }
  /**
    * TAMEX12: Method to get the field value.
    */
  public String getTamex12() {
    return tamex12;
  }
  /**
    * TAMEX12: Method to set the field value.
    */
  public void setTamex12(String PARAM) {
    tamex12 = PARAM;
  }
  /**
    * TAMEX13: Method to get the field value.
    */
  public String getTamex13() {
    return tamex13;
  }
  /**
    * TAMEX13: Method to set the field value.
    */
  public void setTamex13(String PARAM) {
    tamex13 = PARAM;
  }
  /**
    * TAMEX14: Method to get the field value.
    */
  public String getTamex14() {
    return tamex14;
  }
  /**
    * TAMEX14: Method to set the field value.
    */
  public void setTamex14(String PARAM) {
    tamex14 = PARAM;
  }
  /**
    * TAMEX15: Method to get the field value.
    */
  public String getTamex15() {
    return tamex15;
  }
  /**
    * TAMEX15: Method to set the field value.
    */
  public void setTamex15(String PARAM) {
    tamex15 = PARAM;
  }
  /**
    * TAMEX16: Method to get the field value.
    */
  public String getTamex16() {
    return tamex16;
  }
  /**
    * TAMEX16: Method to set the field value.
    */
  public void setTamex16(String PARAM) {
    tamex16 = PARAM;
  }
  /**
    * TAMEX17: Method to get the field value.
    */
  public String getTamex17() {
    return tamex17;
  }
  /**
    * TAMEX17: Method to set the field value.
    */
  public void setTamex17(String PARAM) {
    tamex17 = PARAM;
  }
  /**
    * TAMEX18: Method to get the field value.
    */
  public String getTamex18() {
    return tamex18;
  }
  /**
    * TAMEX18: Method to set the field value.
    */
  public void setTamex18(String PARAM) {
    tamex18 = PARAM;
  }
  /**
    * TAMEX19: Method to get the field value.
    */
  public String getTamex19() {
    return tamex19;
  }
  /**
    * TAMEX19: Method to set the field value.
    */
  public void setTamex19(String PARAM) {
    tamex19 = PARAM;
  }
  /**
    * TAMEX20: Method to get the field value.
    */
  public String getTamex20() {
    return tamex20;
  }
  /**
    * TAMEX20: Method to set the field value.
    */
  public void setTamex20(String PARAM) {
    tamex20 = PARAM;
  }
  /**
    * LIN_CDGO: Method to get the field value.
    */
  public String getLin_cdgo() {
    return lin_cdgo;
  }
  /**
    * LIN_CDGO: Method to set the field value.
    */
  public void setLin_cdgo(String PARAM) {
    lin_cdgo = PARAM;
  }
  /**
    * REF_CDGO: Method to get the field value.
    */
  public String getRef_cdgo() {
    return ref_cdgo;
  }
  /**
    * REF_CDGO: Method to set the field value.
    */
  public void setRef_cdgo(String PARAM) {
    ref_cdgo = PARAM;
  }
  /**
    * ATUALIZA: Method to get the field value.
    */
  public String getAtualiza() {
    return atualiza;
  }
  /**
    * ATUALIZA: Method to set the field value.
    */
  public void setAtualiza(String PARAM) {
    atualiza = PARAM;
  }
  /**
    * Reset all fields.
    */
  public void reset(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    gde_cdgo = null;
    qtd_nume = null;
    qtd_pars = null;
    tam1 = null;
    tamex1 = null;
    par1 = null;
    tam2 = null;
    tamex2 = null;
    par2 = null;
    tam3 = null;
    par3 = null;
    tam4 = null;
    par4 = null;
    tam5 = null;
    par5 = null;
    tam6 = null;
    par6 = null;
    tam7 = null;
    par7 = null;
    tam8 = null;
    par8 = null;
    tam9 = null;
    par9 = null;
    tam10 = null;
    par10 = null;
    tam11 = null;
    par11 = null;
    tam12 = null;
    par12 = null;
    tam13 = null;
    par13 = null;
    tam14 = null;
    par14 = null;
    tam15 = null;
    par15 = null;
    tam16 = null;
    par16 = null;
    tam17 = null;
    par17 = null;
    tam18 = null;
    par18 = null;
    tam19 = null;
    par19 = null;
    tam20 = null;
    par20 = null;
    numero_item = null;
    total = null;
    indice = null;
    tamex3 = null;
    tamex4 = null;
    tamex5 = null;
    tamex6 = null;
    tamex7 = null;
    tamex8 = null;
    tamex9 = null;
    tamex10 = null;
    tamex11 = null;
    tamex12 = null;
    tamex13 = null;
    tamex14 = null;
    tamex15 = null;
    tamex16 = null;
    tamex17 = null;
    tamex18 = null;
    tamex19 = null;
    tamex20 = null;
    lin_cdgo = null;
    ref_cdgo = null;
    atualiza = null;
  }
  /**
    * Validate fields and return errors.
    */
  public ActionErrors validate(org.apache.struts.action.ActionMapping mapping, javax.servlet.http.HttpServletRequest request) {
    javax.servlet.http.HttpSession session = request.getSession(true);
    ActionForward actionForward = null;
    ActionErrors errors = new ActionErrors();
    valida = false;
    if (errors != null && errors.size() > 0) {
      session.setAttribute(mapping.getName(), this);
    }
    return errors;
  }
}

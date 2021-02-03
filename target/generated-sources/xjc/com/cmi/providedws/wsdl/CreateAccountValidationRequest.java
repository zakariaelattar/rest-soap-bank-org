//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.0 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2021.01.31 à 03:34:06 PM GMT 
//


package com.cmi.providedws.wsdl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cin" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bank_id" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cin",
    "bankId"
})
@XmlRootElement(name = "createAccountValidationRequest", namespace = "http://www.cmi.com/xml/account")
public class CreateAccountValidationRequest {

    @XmlElement(namespace = "http://www.cmi.com/xml/account", required = true)
    protected String cin;
    @XmlElement(name = "bank_id", namespace = "http://www.cmi.com/xml/account")
    protected long bankId;

    /**
     * Obtient la valeur de la propriété cin.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCin() {
        return cin;
    }

    /**
     * Définit la valeur de la propriété cin.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCin(String value) {
        this.cin = value;
    }

    /**
     * Obtient la valeur de la propriété bankId.
     * 
     */
    public long getBankId() {
        return bankId;
    }

    /**
     * Définit la valeur de la propriété bankId.
     * 
     */
    public void setBankId(long value) {
        this.bankId = value;
    }

}

package dk.sdu.mmmi.opn.swaggerbank.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * Account
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class Account   {
  private Float balance = null;

  private String name = null;

  private Integer number = null;

  private Float positiveInterest = null;

  private Float negativeInterest = null;

  public Account balance(Float balance) {
    this.balance = balance;
    return this;
  }

   /**
   * Get balance
   * @return balance
  **/
  @ApiModelProperty(value = "")
  public Float getBalance() {
    return balance;
  }

  public void setBalance(Float balance) {
    this.balance = balance;
  }

  public Account name(String name) {
    this.name = name;
    return this;
  }

   /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Account number(Integer number) {
    this.number = number;
    return this;
  }

   /**
   * Get number
   * @return number
  **/
  @ApiModelProperty(value = "")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public Account positiveInterest(Float positiveInterest) {
    this.positiveInterest = positiveInterest;
    return this;
  }

   /**
   * Get positiveInterest
   * @return positiveInterest
  **/
  @ApiModelProperty(value = "")
  public Float getPositiveInterest() {
    return positiveInterest;
  }

  public void setPositiveInterest(Float positiveInterest) {
    this.positiveInterest = positiveInterest;
  }

  public Account negativeInterest(Float negativeInterest) {
    this.negativeInterest = negativeInterest;
    return this;
  }

   /**
   * Get negativeInterest
   * @return negativeInterest
  **/
  @ApiModelProperty(value = "")
  public Float getNegativeInterest() {
    return negativeInterest;
  }

  public void setNegativeInterest(Float negativeInterest) {
    this.negativeInterest = negativeInterest;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.balance, account.balance) &&
        Objects.equals(this.name, account.name) &&
        Objects.equals(this.number, account.number) &&
        Objects.equals(this.positiveInterest, account.positiveInterest) &&
        Objects.equals(this.negativeInterest, account.negativeInterest);
  }

  @Override
  public int hashCode() {
    return Objects.hash(balance, name, number, positiveInterest, negativeInterest);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    positiveInterest: ").append(toIndentedString(positiveInterest)).append("\n");
    sb.append("    negativeInterest: ").append(toIndentedString(negativeInterest)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


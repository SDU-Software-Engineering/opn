package dk.sdu.mmmi.opn.swaggerbank.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * DepositOrWithdrawDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class DepositOrWithdrawDTO   {
  private Credential credential = null;

  private Float amount = null;

  private Integer accountId = null;

  public DepositOrWithdrawDTO credential(Credential credential) {
    this.credential = credential;
    return this;
  }

   /**
   * Credential information
   * @return credential
  **/
  @ApiModelProperty(value = "Credential information")
  public Credential getCredential() {
    return credential;
  }

  public void setCredential(Credential credential) {
    this.credential = credential;
  }

  public DepositOrWithdrawDTO amount(Float amount) {
    this.amount = amount;
    return this;
  }

   /**
   * Amount information
   * @return amount
  **/
  @ApiModelProperty(value = "Amount information")
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public DepositOrWithdrawDTO accountId(Integer accountId) {
    this.accountId = accountId;
    return this;
  }

   /**
   * Account ID
   * @return accountId
  **/
  @ApiModelProperty(value = "Account ID")
  public Integer getAccountId() {
    return accountId;
  }

  public void setAccountId(Integer accountId) {
    this.accountId = accountId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DepositOrWithdrawDTO depositOrWithdrawDTO = (DepositOrWithdrawDTO) o;
    return Objects.equals(this.credential, depositOrWithdrawDTO.credential) &&
        Objects.equals(this.amount, depositOrWithdrawDTO.amount) &&
        Objects.equals(this.accountId, depositOrWithdrawDTO.accountId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credential, amount, accountId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DepositOrWithdrawDTO {\n");
    
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    accountId: ").append(toIndentedString(accountId)).append("\n");
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


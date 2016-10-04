/**
 * Banking dotnet Core Wep API
 * A simple api to use banking services
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package dk.sdu.mmmi.opn.swaggerbank.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * DepositOrWithdrawDTO
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-03T22:22:42.534+02:00")
public class DepositOrWithdrawDTO   {
  @SerializedName("credential")
  private Credential credential = null;

  @SerializedName("amount")
  private Float amount = null;

  @SerializedName("accountId")
  private Integer accountId = null;

  public DepositOrWithdrawDTO credential(Credential credential) {
    this.credential = credential;
    return this;
  }

   /**
   * Credential information
   * @return credential
  **/
  @ApiModelProperty(example = "null", value = "Credential information")
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
  @ApiModelProperty(example = "null", value = "Amount information")
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
  @ApiModelProperty(example = "null", value = "Account ID")
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

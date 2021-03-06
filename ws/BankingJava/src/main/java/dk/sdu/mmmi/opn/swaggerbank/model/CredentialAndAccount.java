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
import dk.sdu.mmmi.opn.swaggerbank.model.Account;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * Class used for creating an account for given credentials.
 */
@ApiModel(description = "Class used for creating an account for given credentials.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-10-03T22:22:42.534+02:00")
public class CredentialAndAccount   {
  @SerializedName("credential")
  private Credential credential = null;

  @SerializedName("account")
  private Account account = null;

  public CredentialAndAccount credential(Credential credential) {
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

  public CredentialAndAccount account(Account account) {
    this.account = account;
    return this;
  }

   /**
   * Account information
   * @return account
  **/
  @ApiModelProperty(example = "null", value = "Account information")
  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CredentialAndAccount credentialAndAccount = (CredentialAndAccount) o;
    return Objects.equals(this.credential, credentialAndAccount.credential) &&
        Objects.equals(this.account, credentialAndAccount.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credential, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CredentialAndAccount {\n");
    
    sb.append("    credential: ").append(toIndentedString(credential)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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


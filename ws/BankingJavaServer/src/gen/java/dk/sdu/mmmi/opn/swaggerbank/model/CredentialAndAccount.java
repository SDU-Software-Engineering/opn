package dk.sdu.mmmi.opn.swaggerbank.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import dk.sdu.mmmi.opn.swaggerbank.model.Account;
import dk.sdu.mmmi.opn.swaggerbank.model.Credential;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Class used for creating an account for given credentials.
 **/

/**
 * Class used for creating an account for given credentials.
 */
@ApiModel(description = "Class used for creating an account for given credentials.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-10-04T09:28:53.557+02:00")
public class CredentialAndAccount   {
  private Credential credential = null;

  private Account account = null;

  public CredentialAndAccount credential(Credential credential) {
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

  public CredentialAndAccount account(Account account) {
    this.account = account;
    return this;
  }

   /**
   * Account information
   * @return account
  **/
  @ApiModelProperty(value = "Account information")
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


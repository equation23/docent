import com.docent.sp1.domain.DocentAuth;
import com.docent.sp1.domain.DocentMember;
import com.docent.sp1.mapper.MemberMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")

public class MemberTests {

    @Autowired(required = false)
    private MemberMapper mapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testInsert() {

        for (int i = 0; i < 100; i++) {

            DocentMember docentMember = DocentMember.builder()
                    .did("user"+i)
                    .dpw(passwordEncoder.encode("111"))
                    .dname("USER"+i)
                    .nickname("사용자"+i)
                    .build();

            mapper.register(docentMember);

            if(i > 80){
                DocentAuth docentAuth = DocentAuth.builder().did("user"+i).roleName("ADMIN").build();

                mapper.addAuth(docentAuth);

            }

            DocentAuth docentAuth = DocentAuth.builder().did("user"+i).roleName("MEMBER").build();

            mapper.addAuth(docentAuth);



        }//end for


    }

}

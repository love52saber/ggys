package net.seocoo.ggys.module.book.service;

import net.seocoo.ggys.module.book.entity.FreeBookRuleDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author panch
 * @date 2018/5/30 16:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    private BookRuleService bookRuleService;

    @Test
    public void listBookRuleByMerchantId(){
        List<FreeBookRuleDO> freeBookRuleDOList=bookRuleService.listBookRuleByMerchantId(1);
        if(freeBookRuleDOList!=null && freeBookRuleDOList.size()>0){
            for(FreeBookRuleDO fdo: freeBookRuleDOList){
                System.out.print(fdo);
            }
        }
    }
}

import cn.e3mall.mapper.TbItemMapper;
import cn.e3mall.pojo.TbItem;
import cn.e3mall.pojo.TbItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class PageHelperTest {
    @Test
    public void testPageHelper()throws Exception{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/applicationContext-dao.xml");
        TbItemMapper itemMapper = applicationContext.getBean(TbItemMapper.class);
        //执行sql语句之前设置分页信息使用pagehelper的startpage方法
        PageHelper.startPage(1,10);
        //执行查询
        TbItemExample example = new TbItemExample();
        List<TbItem> tbItems = itemMapper.selectByExample(example);
        //取分页信息,PageInfo
        PageInfo<TbItem> pageInfo = new PageInfo<>(tbItems);
        System.out.println(pageInfo.getTotal());
        System.out.println(pageInfo.getPages());
        System.out.println(tbItems.size());

    }
}

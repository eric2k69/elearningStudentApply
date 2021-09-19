package store.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// feignclient는 인터페이스 기술로 사용 가능
// url: 호출하고싶은 서비스 주소. http://localhost:8082 - application.yaml에 정의
// fallback = fallback class 지정. ~service interface 를 implementation 해야 함
@FeignClient(name = "Pay", url = "${api.url.pay}", fallback = PayServiceImpl.class)
//@FeignClient(name = "Pay", url = "${api.url.pay}")
public interface PayService {

    // command
    @RequestMapping(method = RequestMethod.POST, path = "/pays", consumes = "application/json")
    public void pay(@RequestBody Pay pay);

}

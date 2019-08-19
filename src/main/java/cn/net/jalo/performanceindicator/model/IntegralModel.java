package cn.net.jalo.performanceindicator.model;

import java.util.List;

import cn.net.jalo.performanceindicator.entity.Integral;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class IntegralModel extends Integral {
	private List<Integer> integralIds;
}

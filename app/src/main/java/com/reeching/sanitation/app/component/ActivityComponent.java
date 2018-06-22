package com.reeching.sanitation.app.component;

import com.reeching.sanitation.app.activity.AddBasicsWcActivity;
import com.reeching.sanitation.app.activity.AddPeopleActivity;
import com.reeching.sanitation.app.activity.AddRoadActivity;
import com.reeching.sanitation.app.activity.AddWasteActivity;
import com.reeching.sanitation.app.activity.DetailsRoadActivity;
import com.reeching.sanitation.app.activity.DetailsWasteActivity;
import com.reeching.sanitation.app.activity.DetailsWcActivity;

import dagger.Component;

/**
 * Created by 绍轩 on 2018/3/7.
 */
@Component(dependencies = AppComponent.class)
public interface ActivityComponent {
    AddBasicsWcActivity inject(AddBasicsWcActivity Activity);
    AddRoadActivity inject(AddRoadActivity Activity);
    AddWasteActivity inject(AddWasteActivity Activity);
    AddPeopleActivity inject(AddPeopleActivity Activity);
    DetailsWcActivity inject(DetailsWcActivity Activity);
    DetailsRoadActivity inject(DetailsRoadActivity Activity);
    DetailsWasteActivity inject(DetailsWasteActivity Activity);
}

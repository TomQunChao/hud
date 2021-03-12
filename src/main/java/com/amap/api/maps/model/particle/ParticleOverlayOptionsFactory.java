package com.amap.api.maps.model.particle;

import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.track.ErrorCode;
import java.util.ArrayList;
import java.util.List;

public class ParticleOverlayOptionsFactory {
    public static final int PARTICLE_TYPE_HAZE = 3;
    public static final int PARTICLE_TYPE_RAIN = 1;
    public static final int PARTICLE_TYPE_SNOWY = 2;
    public static final int PARTICLE_TYPE_SUNNY = 0;

    public static List<ParticleOverlayOptions> defaultOptions(int i) {
        ArrayList arrayList = new ArrayList();
        switch (i) {
            case 0:
                ArrayList arrayList2 = new ArrayList();
                ParticleOverlayOptions particleOverlayOptions = new ParticleOverlayOptions();
                particleOverlayOptions.setMaxParticles(1);
                particleOverlayOptions.setDuration(10000);
                particleOverlayOptions.setParticleEmissionModule(new ParticleEmissionModule(1, 2500));
                particleOverlayOptions.setLoop(true);
                particleOverlayOptions.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
                particleOverlayOptions.setParticleLifeTime(10000);
                particleOverlayOptions.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
                particleOverlayOptions.setParticleOverLifeModule(new ParticleOverLifeModule());
                particleOverlayOptions.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_0.png"));
                particleOverlayOptions.setStartParticleSize(1000, 1000);
                arrayList2.add(particleOverlayOptions);
                ParticleOverlayOptions particleOverlayOptions2 = new ParticleOverlayOptions();
                particleOverlayOptions2.setMaxParticles(1);
                particleOverlayOptions2.setDuration(10000);
                particleOverlayOptions2.setParticleEmissionModule(new ParticleEmissionModule(1, 2500));
                particleOverlayOptions2.setLoop(true);
                particleOverlayOptions2.setParticleShapeModule(new SinglePointParticleShape(0.0f, 0.0f, 0.0f));
                particleOverlayOptions2.setParticleLifeTime(10000);
                particleOverlayOptions2.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f));
                ParticleOverLifeModule particleOverLifeModule = new ParticleOverLifeModule();
                particleOverLifeModule.setRotateOverLife(new ConstantRotationOverLife(45.0f));
                particleOverlayOptions2.setParticleOverLifeModule(particleOverLifeModule);
                particleOverlayOptions2.icon(BitmapDescriptorFactory.fromAsset("map_custom/particle/sun_1.png"));
                particleOverlayOptions2.setStartParticleSize(1000, 1000);
                arrayList2.add(particleOverlayOptions2);
                arrayList.addAll(arrayList2);
                break;
            case 1:
                ParticleOverlayOptions particleOverlayOptions3 = new ParticleOverlayOptions();
                particleOverlayOptions3.setMaxParticles(1000);
                particleOverlayOptions3.setDuration(5000);
                particleOverlayOptions3.setParticleEmissionModule(new ParticleEmissionModule(100, 1000));
                particleOverlayOptions3.setLoop(true);
                particleOverlayOptions3.setParticleLifeTime(5000);
                particleOverlayOptions3.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(10.0f, 1000.0f, 0.0f, 100.0f, 1000.0f, 0.0f));
                particleOverlayOptions3.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
                BitmapDescriptor fromAsset = BitmapDescriptorFactory.fromAsset("map_custom/particle/rain.png");
                particleOverlayOptions3.icon(fromAsset);
                particleOverlayOptions3.setStartParticleSize(fromAsset.getWidth() * 2, fromAsset.getHeight() * 2);
                arrayList.add(particleOverlayOptions3);
                break;
            case 2:
                ParticleOverlayOptions particleOverlayOptions4 = new ParticleOverlayOptions();
                particleOverlayOptions4.setMaxParticles(1000);
                particleOverlayOptions4.setDuration(5000);
                particleOverlayOptions4.setParticleEmissionModule(new ParticleEmissionModule(20, 1000));
                particleOverlayOptions4.setLoop(true);
                particleOverlayOptions4.setParticleShapeModule(new RectParticleShape(0.0f, 0.0f, 1.0f, 0.1f, true));
                particleOverlayOptions4.setParticleLifeTime(10000);
                particleOverlayOptions4.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-50.0f, 100.0f, 0.0f, 50.0f, 200.0f, 0.0f));
                BitmapDescriptor fromAsset2 = BitmapDescriptorFactory.fromAsset("map_custom/particle/snow.png");
                particleOverlayOptions4.icon(fromAsset2);
                particleOverlayOptions4.setStartParticleSize(fromAsset2.getWidth(), fromAsset2.getHeight());
                arrayList.add(particleOverlayOptions4);
                break;
            case 3:
                ArrayList arrayList3 = new ArrayList();
                ParticleOverlayOptions particleOverlayOptions5 = new ParticleOverlayOptions();
                particleOverlayOptions5.setLoop(false);
                particleOverlayOptions5.setMaxParticles(1);
                particleOverlayOptions5.setDuration(10000);
                particleOverlayOptions5.setParticleEmissionModule(new ParticleEmissionModule(1, ErrorCode.Response.SUCCESS));
                particleOverlayOptions5.setParticleShapeModule(new SinglePointParticleShape(0.5f, 0.5f, 0.0f, true));
                particleOverlayOptions5.setParticleLifeTime(10000);
                particleOverlayOptions5.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-10.0f, -0.0f, -0.0f, -20.0f, 0.0f, 0.0f));
                BitmapDescriptor fromAsset3 = BitmapDescriptorFactory.fromAsset("map_custom/particle/fog.png");
                particleOverlayOptions5.icon(fromAsset3);
                particleOverlayOptions5.setStartParticleSize(fromAsset3.getWidth() * 5, fromAsset3.getWidth() * 5);
                arrayList3.add(particleOverlayOptions5);
                ParticleOverlayOptions particleOverlayOptions6 = new ParticleOverlayOptions();
                particleOverlayOptions6.setMaxParticles(1000);
                particleOverlayOptions6.setDuration(10000);
                particleOverlayOptions6.setParticleEmissionModule(new ParticleEmissionModule(30, 2500));
                particleOverlayOptions6.setLoop(true);
                particleOverlayOptions6.setParticleShapeModule(new RectParticleShape(0.5f, 0.5f, 1.0f, 1.0f, true));
                particleOverlayOptions6.setParticleLifeTime(10000);
                particleOverlayOptions6.setParticleStartSpeed(new RandomVelocityBetweenTwoConstants(-100.0f, -100.0f, -1.0f, -200.0f, 100.0f, 1.0f));
                BitmapDescriptor fromAsset4 = BitmapDescriptorFactory.fromAsset("map_custom/particle/haze.png");
                particleOverlayOptions6.icon(fromAsset4);
                particleOverlayOptions6.setStartParticleSize(fromAsset4.getWidth(), fromAsset4.getHeight());
                particleOverlayOptions6.setParticleStartColor(new RandomColorBetWeenTwoConstants(255.0f, 255.0f, 255.0f, 102.0f, 255.0f, 255.0f, 255.0f, 255.0f));
                arrayList3.add(particleOverlayOptions6);
                arrayList.addAll(arrayList3);
                break;
        }
        return arrayList;
    }
}
